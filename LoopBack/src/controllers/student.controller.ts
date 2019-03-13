import {
  repository,
} from '@loopback/repository';
import {
  param,
  get,
} from '@loopback/rest';
import {Student} from '../models';
import {StudentRepository} from '../repositories';

export class StudentController {
  constructor(
    @repository(StudentRepository)
    public studentRepository : StudentRepository,
  ) {}

  @get('/students/add')
  async addStudent(
    @param.query.string('firstName') firstName: string,
    @param.query.string('lastName') lastName: string,
    @param.query.string('group') group: string,
  ): Promise<Student> {
    return await this.studentRepository.create({
      "firstName": firstName,
      "lastName": lastName,
      "group": group,
    });
  }

  @get('/students/all')
  async getAll(): Promise<Student[]> {
    return await this.studentRepository.find();
  }

  @get('/students/{id}')
  async getStudent(@param.path.string('id') id: string): Promise<Student> {
    return await this.studentRepository.findById(id);
  }
}
