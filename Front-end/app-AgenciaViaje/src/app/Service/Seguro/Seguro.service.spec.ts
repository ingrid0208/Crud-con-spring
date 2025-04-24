import { TestBed } from '@angular/core/testing';

import { SeguroService } from './Seguro.service';

describe('SeguroService', () => {
  let service: SeguroService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SeguroService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
