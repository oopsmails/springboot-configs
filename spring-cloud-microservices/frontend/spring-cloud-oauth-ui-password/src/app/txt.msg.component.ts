import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/Observable';

import { AppService, TxtMessage } from './app.service';

@Component({
    // tslint:disable-next-line:component-selector
    selector: 'txtmsg-details',
    providers: [AppService],
    template: `<div class="container">
    <h1 class="col-sm-12">TxtMessage Details</h1>

    <div class="col-sm-12">
        <table class="table">
            <thead>
                <tr>
                    <th>User Name</th>
                    <th>Msg Text</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr *ngFor="let msg of messages">
                    <td>{{ msg.username }}</td>
                    <td>{{ msg.text }}</td>
                    <td>
                        <a [routerLink]="['/', msg.username]">Edit</a>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>

</div>`
})

export class TxtMsgComponent implements OnInit {
    public txtMessage = new TxtMessage('text', 'user foo');
    public messages = new Array<TxtMessage>();
    private foosUrl = '/api/messages/';

    constructor(private _service: AppService) { }

    ngOnInit() {
        this.getMessages();
    }

    getMessages(): void {
        this._service.getResource(this.foosUrl)
            .subscribe(
                data => {
                    this.messages = data;
                    this.txtMessage = this.messages[0];
                },
                error => this.txtMessage.username = 'Error');
    }
}
