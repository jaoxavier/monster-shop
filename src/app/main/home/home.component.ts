import { HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Monster } from 'src/app/models/Monster';
import { MonsterService } from 'src/app/services/monster/monster.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  monsters: Monster[] = [];

  constructor(
    private monsterService: MonsterService
  ){}

  ngOnInit(): void {
      this.monsterService.getAllMonsters().subscribe(
        data => {
          this.monsters = data;
          console.log(data)
        }
      );
  }
  
}
