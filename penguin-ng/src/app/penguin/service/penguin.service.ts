import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Penguins } from "../model/penguins";
import { Penguin } from "../model/penguin";
import { NewPenguin } from "../model/new-penguin";
import { ImagesInfo } from "../model/images-info";

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
    return this.httpClient.get<Penguins>(`/api/penguins`);
  }

  /**
   * Fetches penguin with given taxon key.
   *
   * @param taxonKey taxon key
   */
  getPenguin(taxonKey: string): Observable<Penguin> {
    return this.httpClient.get<Penguin>(`api/penguin/${taxonKey}`)
  }

  /**
   * Send request to apply changes to given penguin.
   *
   * @param penguin penguin changes
   * @param taxonKey taxon key
   */
  putPenguin(penguin: NewPenguin, taxonKey: string): Observable<any> {
    return this.httpClient.put<NewPenguin>(`api/penguin/${taxonKey}`, penguin);
  }

  getImagesInfo(): Observable<ImagesInfo> {
    return this.httpClient.get<ImagesInfo>('api/images');
  }

}
