import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PenguinTableViewComponent } from './penguin-table-view.component';

describe('PenguinTableViewComponent', () => {
  let component: PenguinTableViewComponent;
  let fixture: ComponentFixture<PenguinTableViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PenguinTableViewComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PenguinTableViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
