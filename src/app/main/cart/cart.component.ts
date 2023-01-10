import { Component, OnInit } from '@angular/core';
import { Monster } from 'src/app/models/Monster';
import { MonsterService } from 'src/app/services/monster/monster.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit{

  constructor(
    private monsterService: MonsterService
  ){}

  monsters: Monster[] = [];

  order = {
    client: '',
    items: [
      {monster: 0, quantity: 0}
    ]
  }

  ngOnInit(): void {
    let id = window.localStorage.getItem('id');
    let cartItems = `[${window.sessionStorage.getItem('cart')}]`;

    this.monsterService.getAllMonsters().subscribe(
      data => this.monsters = data
    )

    if(id != null){
      this.order.client = id;
    }
    if(cartItems != null){
      this.order.items = JSON.parse(cartItems);
      this.verifyItems()
    }
  }

  monsterInfo(idMonster: number): any{
    return this.monsters.find(i => i.id == idMonster)
  }

  total(idMonster: number){
    let data = this.order.items.find(i => i.monster == idMonster);
    if(data != undefined){
      return data.quantity * this.monsterInfo(idMonster)?.price;
    }
    return;
  }

  totalQuantity(){
    return this.order.items.reduce((acc, item) => acc + item.quantity, 0)
  }

  totalPrice(){
    let selectedMonsters = this.order.items.map(item => {
      let monster = this.monsters.find(i => i.id === item.monster);
      return monster!?.price * item.quantity
    })

    return selectedMonsters.reduce((acc, item) => acc + item, 0)
  }

  verifyItems(){
    let newItems = this.order.items.reduce((acc: { monster: number; quantity: number; }[] , item) => {
      let existingItem = acc.find(accItem => accItem.monster === item.monster);
      if (existingItem) {
        existingItem.quantity += item.quantity;
      } else {
        acc.push(item);
      }
      return acc;
    }, []);
    
    this.order.items = newItems;
  }
}
