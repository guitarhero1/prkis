import {DefaultCrudRepository} from '@loopback/repository';
import {Student} from '../models';
import {DbDataSource} from '../datasources';
import {inject} from '@loopback/core';

export class StudentRepository extends DefaultCrudRepository<
  Student,
  typeof Student.prototype.id
> {
  constructor(
    @inject('datasources.db') dataSource: DbDataSource,
  ) {
    super(Student, dataSource);

    this.create({
      firstName: "Petro",
      lastName: "Poroshenko",
      group: "0"
    });

    this.create({
      firstName: "Yuri",
      lastName: "Dud",
      group: "0"
    });

    this.create({
      firstName: "Thomas",
      lastName: "Anders",
      group: "1"
    });
  }
}
