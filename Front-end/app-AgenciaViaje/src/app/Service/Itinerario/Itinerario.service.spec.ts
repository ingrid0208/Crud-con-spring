import { TestBed } from '@angular/core/testing';

import { ItinerarioService } from './Itinerario.service';

describe('ItinerarioService', () => {
  let service: ItinerarioService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ItinerarioService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
