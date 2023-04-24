import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Proyecto } from 'src/app/model/proyecto';
import { ProyectoService } from 'src/app/service/proyecto.service';

@Component({
  selector: 'app-new-proyecto',
  templateUrl: './new-proyecto.component.html',
  styleUrls: ['./new-proyecto.component.css']
})
  export class NewProyectoComponent implements OnInit {
    nombreP: string;
    descripcionP: string;
  
    constructor(private proyectoS: ProyectoService, private router: Router){}
  
    ngOnInit(): void {
      
    }
  
   onCreate(): void{
    const proyecto = new Proyecto(this.nombreP, this.descripcionP);
    this.proyectoS.save(proyecto).subscribe(
      data =>{
        alert("El proyecto ha sido añadido exitosamente");
        this.router.navigate(['']);
      }, err =>{
        alert("falló");
        this.router.navigate(['']);
      }
    )
   }
  
  }


