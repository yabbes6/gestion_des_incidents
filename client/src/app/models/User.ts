import { Incident } from "./incident"
import { Comment } from "./comment"

export class User{
    id?:number
    nom?: string
    prenom?:string
    username?:string
    password?:string
    incident?:Incident[]
    comment?:Comment[]

}