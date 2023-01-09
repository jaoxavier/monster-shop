import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuantityMonsterDialogComponent } from './quantity-monster-dialog.component';

describe('QuantityMonsterDialogComponent', () => {
  let component: QuantityMonsterDialogComponent;
  let fixture: ComponentFixture<QuantityMonsterDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ QuantityMonsterDialogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(QuantityMonsterDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
