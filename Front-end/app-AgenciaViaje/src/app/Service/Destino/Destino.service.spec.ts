import { TestBed } from '@angular/core/testing';

import { DestinoService } from './Destino.service';

describe('DestinoService', () => {
  let service: DestinoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DestinoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
