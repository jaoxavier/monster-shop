import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MonstersAllComponent } from './monsters-all.component';

describe('MonstersAllComponent', () => {
  let component: MonstersAllComponent;
  let fixture: ComponentFixture<MonstersAllComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MonstersAllComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MonstersAllComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
