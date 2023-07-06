import { Component } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  newrequest() {
    // Lógica para manejar el evento de clic del botón "Nueva solicitud"
    console.log('Clic en Nueva solicitud');
  }
}