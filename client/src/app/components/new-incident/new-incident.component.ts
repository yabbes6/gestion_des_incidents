import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Incident } from 'src/app/models/incident';

@Component({
  selector: 'app-new-incident',
  templateUrl: './new-incident.component.html',
  styleUrls: ['./new-incident.component.scss']
})
export class NewIncidentComponent implements OnInit {
  
  incident:Incident= new Incident();

  @Input() hide=true;

  @Output() event= new EventEmitter<boolean>()
  

  ngOnInit(): void {

  }

  onSubmit(){

  }
  onHide(){
    this.hide = !this.hide;
    this.event.emit(this.hide)
  }
  
}
