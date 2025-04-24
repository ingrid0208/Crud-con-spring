import { TestBed } from '@angular/core/testing';

import { PaqueteService } from './Paquete.service';

describe('PaqueteService', () => {
  let service: PaqueteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PaqueteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
