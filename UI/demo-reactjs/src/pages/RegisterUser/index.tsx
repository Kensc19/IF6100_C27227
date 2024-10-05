import { Input,Space,Button } from 'antd';
import React from 'react';

const RegisterUser = ( ) => {
    return (
    <>
        <Space direction="vertical">
            <Input placeholder="Enter your name" />
            <Input placeholder="Enter your email" />
            <Input type="password" placeholder="Enter your password" />
            <Button type= "primary">Register</Button>
        </Space>
    </>
    );
}
export default RegisterUser;