import { Component, EventEmitter, Inject, Output } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

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
  ){
    this.item.monster = data
  }

  confirm(){
    this.confirmed.emit();
  }

}
