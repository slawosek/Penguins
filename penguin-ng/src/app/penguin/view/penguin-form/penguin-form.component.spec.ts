import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PenguinFormComponent } from './penguin-form.component';
import { PenguinService } from "../../service/penguin.service";
import { mock } from "@typestrong/ts-mockito";
import { RouterModule } from "@angular/router";

describe('PenguinFormComponent', () => {
  let component: PenguinFormComponent;
  let fixture: ComponentFixture<PenguinFormComponent>;
  let penguinService: PenguinService;


  beforeEach(async () => {
    penguinService = mock(PenguinService);

    await TestBed.configureTestingModule({
      declarations: [PenguinFormComponent],
      imports: [ RouterModule.forRoot([]) ],
      providers: [
        {
          provide: PenguinService,
          useValue: penguinService
        }
      ]
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
