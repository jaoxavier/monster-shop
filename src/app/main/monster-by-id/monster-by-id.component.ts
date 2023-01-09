import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Monster } from 'src/app/models/Monster';
import { description } from 'src/app/object/description';
import { MonsterService } from 'src/app/services/monster/monster.service';

@Component({
  selector: 'app-monster-by-id',
  templateUrl: './monster-by-id.component.html',
  styleUrls: ['./monster-by-id.component.css']
})
export class MonsterByIdComponent {

  idMonster!: number;
  monster!: Monster;
  fullDescription!: any;

  description = description;


  constructor(
    private router: ActivatedRoute,
    private monsterService: MonsterService
  ){
    this.router.params.subscribe(
      (params) => {
        this.idMonster = params['id']
        
        this.fullDescription = this.description.find(i => i.id == this.idMonster);
        this.monsterService.getMonsterById(this.idMonster).subscribe(
          data => {
            this.monster = data
          }
        )
      }
    )
  }

}
