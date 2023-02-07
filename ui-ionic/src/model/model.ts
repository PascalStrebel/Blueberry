/* tslint:disable */
/* eslint-disable */
// Generated using typescript-generator version 3.1.1185 on 2023-02-07 14:10:06.

export interface Child extends Person {
}

export interface ChildObservation {
    id: ChildObservationKey;
    child: Child;
    observation: Observation;
    createdAt: Date;
    points: number;
    comment: string;
}

export interface ChildObservationKey extends Serializable {
    childId: number;
    observationId: number;
}

export interface Observation {
    id: number;
    expectedAtMonths: number;
    category: string;
    text: string;
    childObservations: ChildObservation[];
}

export interface Person {
    id: number;
    name: string;
    firstName: string;
    birthdate: Date;
    nationality: string;
    entryDate: Date;
    gender: Gender;
}

export interface Todo {
    id: number;
    name: string;
    description: string;
}

export interface Serializable {
}

export type Gender = "M" | "W" | "D";
