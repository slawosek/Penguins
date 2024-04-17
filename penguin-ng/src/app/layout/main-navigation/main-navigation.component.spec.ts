import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MainNavigationComponent } from './main-navigation.component';
import { MatIconModule } from "@angular/material/icon";

describe('MainNavigationComponent', () => {
  let component: MainNavigationComponent;
  let fixture: ComponentFixture<MainNavigationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MainNavigationComponent],
      imports: [MatIconModule]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MainNavigationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
