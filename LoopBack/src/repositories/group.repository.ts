import {DefaultCrudRepository} from '@loopback/repository';
import {Group} from '../models';
import {DbDataSource} from '../datasources';
import {inject} from '@loopback/core';

export class GroupRepository extends DefaultCrudRepository<
  Group,
  typeof Group.prototype.id
> {
  constructor(
    @inject('datasources.db') dataSource: DbDataSource,
  ) {
    super(Group, dataSource);

    this.create({
      code: "IT-41",
      entry: "2015"
    });

    this.create({
      code: "IT-41",
      entry: "2014"
    });
  }
}
