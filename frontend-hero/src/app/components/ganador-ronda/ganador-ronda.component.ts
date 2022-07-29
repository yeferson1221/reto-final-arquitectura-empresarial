import { Component, OnInit } from '@angular/core';
import { AngularFireAuth } from '@angular/fire/compat/auth';
import { Router } from '@angular/router';
import { Jugador } from '../models/jugador';
import { TableroService } from 'src/app/services/tablero.service';
import { JuegoService } from 'src/app/services/juego.service';
import { Juego } from '../models/juego';



@Component({
  selector: 'app-ganador-ronda',
  templateUrl: './ganador-ronda.component.html',
  styleUrls: ['./ganador-ronda.component.css']
})
export class GanadorRondaComponent implements OnInit {
  dataUser: any;

  jugadores: Jugador[] = [];
  juegos: Juego[]=[];

  idjuegoId: any;
  
  constructor(
    private afAuth: AngularFireAuth,
    private router: Router,
    private tableroService: TableroService,
    private juegoService: JuegoService,
  ) { }

  ngOnInit(): void {
    this.afAuth.currentUser.then(user => {
      if(user && user.emailVerified) {
        this.dataUser = user;
        console.log(user)
      } else {
        this.router.navigate(['/login']);
      }
    })
  }

  logOut() {
    this.afAuth.signOut().then(() => this.router.navigate(['/login']));
  }

  
listarJuego() {
    
  this.juegoService.listarJuego().subscribe(data => {
    this.juegos = data;
    this.juegos.forEach(juego=>{this.idjuegoId = juego.id})
    console.log(this.juegos)
  }, error => {
    console.log(error);

  })
}

  listarGanador(){
    this.tableroService.optenerGanadorRonda('1',this.idjuegoId).subscribe(data=>{
      this.jugadores.push(data)
    })
  }

}
