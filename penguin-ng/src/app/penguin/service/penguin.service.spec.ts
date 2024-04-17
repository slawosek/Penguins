import { TestBed } from '@angular/core/testing';

import { PenguinService } from './penguin.service';
import { HttpClient } from "@angular/common/http";
import { instance, mock } from "@typestrong/ts-mockito";

describe('PenguinService', () => {
  let service: PenguinService;
  let http: HttpClient;


  beforeEach(() => {
    http = mock(HttpClient);

    TestBed.configureTestingModule({
      providers: [
        {
          provide: HttpClient,
          useValue: instance(http)
        }
      ]
    });
    service = TestBed.inject(PenguinService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
