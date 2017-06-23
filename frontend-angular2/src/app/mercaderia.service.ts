import { Injectable } from '@angular/core';

import { Http, Response, Headers, URLSearchParams, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';

import { Mercaderia } from './mercaderia';



@Injectable()
export class MercaderiaService {

  //URLs for CRUD operations
    allMercaderiasUrl = "http://localhost:8080/usuarios/all-mercaderias";
	  MercaderiaUrl =      "http://localhost:8080/usuarios/mercaderia";
	//Create constructor to get Http instance

  constructor(private http:Http) { }

   getAllMercaderias(): Observable<Mercaderia[]> {
        return this.http.get(this.allMercaderiasUrl)
		   		.map(this.extractData)
		        .catch(this.handleError);
}

//Create mercaderia
    createMercaderia(mercaderia: Mercaderia):Observable<number> {
	    let cpHeaders = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: cpHeaders });
        return this.http.post(this.MercaderiaUrl, mercaderia, options)
               .map(success => success.status)
               .catch(this.handleError);
    }

  // mercaderia by id
    getMercaderiaById(mercaderiaId: string): Observable<Mercaderia> {
		let cpHeaders = new Headers({ 'Content-Type': 'application/json' });
		let cpParams = new URLSearchParams();
		cpParams.set('id', mercaderiaId);			
		let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
		return this.http.get(this.MercaderiaUrl, options)
			   .map(this.extractData)
			   .catch(this.handleError);
    }	


//Update mercaderia
    updateMercaderia(article: Mercaderia):Observable<number> {
	    let cpHeaders = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: cpHeaders });
        return this.http.put(this.MercaderiaUrl, article, options)
               .map(success => success.status)
               .catch(this.handleError);
    }



  private extractData(res: Response) {
	    let body = res.json();
        return body;
    }
    
    private handleError (error: Response | any) {
		console.error(error.message || error);
		return Observable.throw(error.status);
    }




}
