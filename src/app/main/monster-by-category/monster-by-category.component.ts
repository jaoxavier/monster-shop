import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';
import { Monster } from 'src/app/models/Monster';
import { MonsterService } from 'src/app/services/monster/monster.service';
import { QuantityMonsterDialogComponent } from '../layout/quantity-monster-dialog/quantity-monster-dialog.component';

@Component({
  selector: 'app-monster-by-category',
  templateUrl: './monster-by-category.component.html',
  styleUrls: ['./monster-by-category.component.css']
})
export class MonsterByCategoryComponent implements OnInit {

  category!: string;
  monsters: Monster[] = [];

  constructor(
    private router: ActivatedRoute,
    private monsterService: MonsterService,
    private dialogRef: MatDialog
  ){
    this.router.params.subscribe(
      (params) => {
        this.category = params['category']
        this.monsterService.getMonsterByCategory(this.category).subscribe(
          data => this.monsters = data
        )
      }
    )
  }

  ngOnInit(): void {
    
  }

  openDialog(idMonster: number){
    this.dialogRef.open(QuantityMonsterDialogComponent, {
      data : {
        id: idMonster
      }
    });
  }

}
