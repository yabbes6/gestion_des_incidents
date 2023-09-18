import { Incident } from "./incident"
import { Comment } from "./comment"
import { Role } from "./role"

export class User{
    id?:number
    nom?: string
    prenom?:string
    username?:string
    roles:Role[]
    password?:string

}