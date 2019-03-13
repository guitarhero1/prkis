import {Entity, model, property} from '@loopback/repository';

@model()
export class Group extends Entity {
  @property({
    type: 'string',
    id: true,
  })
  id: string;

  @property({
    type: 'string',
  })
  code?: string;

  @property({
    type: 'string',
  })
  entry?: string;


  constructor(data?: Partial<Group>) {
    super(data);
  }
}
