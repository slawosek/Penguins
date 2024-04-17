import { TestBed } from '@angular/core/testing';
import { AppComponent } from './app.component';
import { MainComponent } from "./layout/main/main.component";
import { MainNavigationComponent } from "./layout/main-navigation/main-navigation.component";
import { MockComponent } from 'ng-mocks';

describe('AppComponent', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [
        AppComponent,
        MockComponent(MainNavigationComponent),
        MockComponent(MainComponent)
      ],
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

});
