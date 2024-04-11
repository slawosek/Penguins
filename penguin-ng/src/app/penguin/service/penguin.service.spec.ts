import { TestBed } from '@angular/core/testing';

import { PenguinService } from './penguin.service';

describe('PenguinService', () => {
  let service: PenguinService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PenguinService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
