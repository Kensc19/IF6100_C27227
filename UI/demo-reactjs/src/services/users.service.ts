import { RegisterUserRequest } from '../models/user.models';
import { doPost } from './http.service';

export const registerUser = async (
	user: RegisterUserRequest,
): Promise<Response> => {
	const response = await doPost<RegisterUserRequest, Response>(
		user,
		'/api/public/register',
	);

	return response;
};