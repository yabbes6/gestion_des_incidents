import { User } from "./User";
import { Comment } from "./comment";

export class Incident{
    id?:number
    description?:string
    date_creation?:Date
    comment?:Comment[]
    user?:string
    incidentType?:string
    priorite?:string
    status?:string
}
