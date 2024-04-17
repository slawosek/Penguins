import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PenguinTableViewComponent } from './penguin-table-view.component';
import { PenguinService } from "../../service/penguin.service";
import { mock } from "@typestrong/ts-mockito";
import { BehaviorSubject } from "rxjs";
import { Penguins } from "../../model/penguins";
import { CdkTableModule } from "@angular/cdk/table";
import { RouterModule } from "@angular/router";

describe('PenguinTableViewComponent', () => {
  let component: PenguinTableViewComponent;
  let fixture: ComponentFixture<PenguinTableViewComponent>;
  let penguinService: PenguinService;

  beforeEach(async () => {
    penguinService = mock(PenguinService);

    await TestBed.configureTestingModule({
      declarations: [PenguinTableViewComponent],
      imports: [
        CdkTableModule,
        RouterModule.forRoot([])
      ],
      providers: [
        {
          provide: PenguinService,
          useValue: penguinService
        }
      ]
    })
      .compileComponents();

    fixture = TestBed.createComponent(PenguinTableViewComponent);
    component = fixture.componentInstance;
    component.penguins = new BehaviorSubject<Penguins>({
      penguins: [
        {
          taxonKey: "2481643",
          scientificName: "Eudyptes chrysolophus (Brandt  1837)",
          numberOfOccurrences: 121,
          acceptedScientificName: "Eudyptes chrysolophus (Brandt  1837)",
          species: "Eudyptes chrysolophus"
        }
      ]
    });
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
