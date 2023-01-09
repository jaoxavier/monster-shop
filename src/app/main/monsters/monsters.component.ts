import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Monster } from 'src/app/models/Monster';
import { MonsterService } from 'src/app/services/monster/monster.service';
import { QuantityMonsterDialogComponent } from '../layout/quantity-monster-dialog/quantity-monster-dialog.component';

@Component({
  selector: 'app-monsters',
  templateUrl: './monsters.component.html',
  styleUrls: ['./monsters.component.css']
})
export class MonstersComponent implements OnInit{

  monsters: Monster[] = [];
  
  constructor(
    private monsterService: MonsterService,
    private dialogRef: MatDialog
  ){}
  
  ngOnInit(): void {
    this.monsterService.getAllMonsters().subscribe(
      data => {
        this.monsters = data;
      }
    )
  }

  openDialog(idMonster: number){
    this.dialogRef.open(QuantityMonsterDialogComponent, {
      data : {
        id: idMonster
      }
    })
  }

}
