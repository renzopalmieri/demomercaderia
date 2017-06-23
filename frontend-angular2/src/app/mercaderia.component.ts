import { Component, OnInit } from '@angular/core';

import { FormControl, FormGroup, Validators } from '@angular/forms';

import { MercaderiaService } from './mercaderia.service';
import { Mercaderia } from './mercaderia';

@Component({
  selector: 'app-mercaderia',
  templateUrl: './mercaderia.component.html',
  styleUrls: ['./mercaderia.component.css']
})



export class MercaderiaComponent implements OnInit {

  //Component properties
   allMercaderia: Mercaderia[];
   statusCode: number;
   requestProcessing = false;
   mercaderiaIdToUpdate = null;
   processValidation = false;

   mercaderiaForm = new FormGroup({
       nombre: new FormControl('', Validators.required),
       categoria: new FormControl('', Validators.required)	   
   });

  constructor(private mercaderiaService: MercaderiaService) { }

  ngOnInit() {
    this.getAllMercaderias;
  }


getAllMercaderias() {
        this.mercaderiaService.getAllMercaderias()
		  .subscribe(
                data => this.allMercaderia = data,
                errorCode =>  this.statusCode = errorCode);   
   }

  onMercaderiaFormSubmit() {
	  this.processValidation = true;   
	  if (this.mercaderiaForm.invalid) {
	       return; //Validation failed, exit from method.
	  }   
	  //Form is valid, now perform create or update
      this.preProcessConfigurations();
      
	  let nombre = this.mercaderiaForm.get('nombre').value.trim();
      let categoria = this.mercaderiaForm.get('categoria').value.trim();	  
	  if (this.mercaderiaIdToUpdate === null) {  
	    //Handle create article
	    let mercaderia= new Mercaderia(null, nombre, categoria);	  
	    this.mercaderiaService.createMercaderia(mercaderia)
	      .subscribe(successCode => {
		            this.statusCode = successCode;
				    this.getAllMercaderias();	
					this.backToCreateMercaderia();
			    },
		        errorCode => this.statusCode = errorCode);
	  } else {  


   	    //Handle update article
	    let mercaderia= new Mercaderia(this.mercaderiaIdToUpdate, nombre, categoria);	  
	    
  this.mercaderiaService.updateMercaderia(mercaderia)
	      .subscribe(successCode => {
		            this.statusCode = successCode;
				    this.getAllMercaderias();	
					this.backToCreateMercaderia();
			    },
		        errorCode => this.statusCode = errorCode);	  
	  }
   }







   preProcessConfigurations() {
      this.statusCode = null;
	  this.requestProcessing = true;   
   }
   //Go back from update to create
   backToCreateMercaderia() {
      this.mercaderiaIdToUpdate = null;
      this.mercaderiaForm.reset();	  
	  this.processValidation = false;
   }

}
