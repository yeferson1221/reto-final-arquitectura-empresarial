import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Mazo } from '../components/models/mazo';


@Injectable({
  providedIn: 'root'
}
)
export class MazoService {

  url = '/api/mazo/';
 
  constructor(private http: HttpClient) { }

  optenerMazo(): Observable<any> {
    return this.http.get(this.url);
  }

}
