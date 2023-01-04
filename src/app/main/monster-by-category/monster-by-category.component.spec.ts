import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MonsterByCategoryComponent } from './monster-by-category.component';

describe('MonsterByCategoryComponent', () => {
  let component: MonsterByCategoryComponent;
  let fixture: ComponentFixture<MonsterByCategoryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MonsterByCategoryComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MonsterByCategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
