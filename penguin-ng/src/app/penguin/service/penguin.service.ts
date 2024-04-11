import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Penguins } from "../model/penguins";

/**
 * Service responsible for managing penguins.
 */
@Injectable({
  providedIn: 'root'
})
export class PenguinService {

  /**
   * @param httpClient http client
   */
  constructor(private httpClient: HttpClient) { }

  /**
   * Fetches all penguins
   */
  getPenguins(): Observable<Penguins> {
    return this.httpClient.get<Penguins>('/api/penguins');
  }

}
