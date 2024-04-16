import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PenguinFormComponent } from './penguin-form.component';

describe('PenguinFormComponent', () => {
  let component: PenguinFormComponent;
  let fixture: ComponentFixture<PenguinFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PenguinFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PenguinFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
