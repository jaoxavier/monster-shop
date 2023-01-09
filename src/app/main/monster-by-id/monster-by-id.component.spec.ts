import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MonsterByIdComponent } from './monster-by-id.component';

describe('MonsterByIdComponent', () => {
  let component: MonsterByIdComponent;
  let fixture: ComponentFixture<MonsterByIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MonsterByIdComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MonsterByIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
