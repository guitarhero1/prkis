import {
  repository,
  } from '@loopback/repository';
import {
  param,
  get,
} from '@loopback/rest';
import {Group, Student} from '../models';
import {GroupRepository, StudentRepository} from '../repositories';

export class GroupController {
  constructor(
    @repository(GroupRepository)
    public groupRepository : GroupRepository,
    @repository(StudentRepository)
    public studentRepository : StudentRepository,
  ) {}

  @get('/groups/add')
  async addGroup(
    @param.query.string('id') id: string,
    @param.query.string('code') code: string,
    @param.query.string('entry') entry: string,
  ): Promise<Group> {
    return await this.groupRepository.create({
      "id": id,
      "code": code,
      "entry": entry,
    });
  }

  @get('/groups/all')
  async getAll(): Promise<Group[]> {
    return await this.groupRepository.find();
  }

  @get('/groups/{id}')
  async getGroup(@param.path.string('id') id: string): Promise<Group> {
    return await this.groupRepository.findById(id);
  }

  @get('/groups/{id}/students')
  async getStudents(@param.path.string('id') id: string): Promise<Student[]> {
    const students = await this.studentRepository.find();
    return await students.filter(v => v.group === id);
  }
}
