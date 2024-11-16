//import { validationSchema } from '@/utils/forms.util';
//import { useNavigate } from 'react-router-dom';

import { LoginForm } from './types';
import { useNavigate } from 'react-router-dom';
import { useSessionHandler } from '../../../hooks/useSessionHandler';
import { useApiHandler } from '../../../hooks/useApiHandlers';
import { login } from '../../../services/users.service';
import { AuthenticationInput, AuthenticationResponse } from '../../../models/user.models';

const useDependencies = () => {
	const { setSessionStore, clearSession } = useSessionHandler();
	const { handleMutation } = useApiHandler();
	//const { setErrorNotificaiton } = useNotificationHandler();
	const navigate = useNavigate();

	const initialValues = {
		username: '',
		password: '',
	};
	const rules = {
		username: [
			{
				required: true,
				message: 'Por favor ingrese su usuario',
			},
		],
		password: [
			{
				required: true,
				message: 'Por favor ingrese su contraseña',
			},
		],
	};

	const handleLogin = async (values: LoginForm) => {
		const user: AuthenticationInput = {
			username: values.username,
			password: values.password,
		};
		clearSession();

		const { result, isError } = await handleMutation(login, user);
		if (isError) {
			//	setErrorNotificaiton(message);
		} else {
			const response = result as AuthenticationResponse;
			setSessionStore({ ...response });
			navigate('/');
		}
	};
	const handleCancel = () => {
		//	navigate('/');
	};

	return { initialValues, rules, handleLogin, handleCancel };
};

export default useDependencies;