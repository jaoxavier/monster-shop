import { Component, EventEmitter, Inject, Output } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-quantity-monster-dialog',
  templateUrl: './quantity-monster-dialog.component.html',
  styleUrls: ['./quantity-monster-dialog.component.css']
})
export class QuantityMonsterDialogComponent {

  @Output() confirmed = new EventEmitter<void>();

  item = {
    monster: 0,
    quantity: 0
  }

  constructor(
    @Inject(MAT_DIALOG_DATA) public data: any,
    private dialog: MatDialog
  ){
    this.item.monster = data.id
  }

  confirm(){
    if(window.sessionStorage.getItem('cart') != null){
      let data = window.sessionStorage.getItem('cart');
      window.sessionStorage.setItem('cart', `${data}, ${JSON.stringify(this.item)}`)
      this.dialog.closeAll();
      return;
    }
    window.sessionStorage.setItem('cart', `${JSON.stringify(this.item)}`)
    this.dialog.closeAll();
  }

}
