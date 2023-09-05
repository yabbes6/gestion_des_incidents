import { User } from "./User";
import { Incident } from "./incident";

export class Comment{
    id?:number;
    comment?:string;
    date_solution?:Date;
    urlImage?:string;
    incident?:Incident;
    user?:User

}