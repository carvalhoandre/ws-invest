import { Form, Button, message, DatePicker, Layout, Menu, Input, InputNumber, Select } from "antd";
import { useEffect, useState } from "react";

import { Link } from 'react-router-dom'
import { retrieveAllCategoria, saveInvestimento } from "../../service/services";

const { Header, Content, Footer } = Layout;
const { Option } = Select;

export default function Cadastrar() {

    const [categorias, setCategorias] = useState([]);
    const [categoria, setCategoria] = useState(null);

    useEffect(() => {
        refreshCategorias();
        return () => {

        }
    }, [categorias])

    async function refreshCategorias() {
        retrieveAllCategoria()
            .then(
                response => {
                    setCategorias(response.data)
                }
            )
    }

    const layout = {
        labelCol: {
            span: 4,
        },
        wrapperCol: {
            span: 3,
        },
    };
    const tailLayout = {
        wrapperCol: {
            offset: 4,
        },
    };

    const onFinish = (values) => {
        console.log(values)
        saveInvestimento(values)
        message.success("Inestimento salvo com sucesso")
    }

    const onFinishFailed = (values) => {
        message.danger("Falha ao cadastrar")
        console.log('Failde: ', values)
    }

    function handleChange(value) {
        setCategoria(value)
    }

    return (
        <div className="contianer">
            <Layout className="layout">
                <Header>
                    <div className="logo" />
                    <Menu theme="dark" mode="horizontal" defaultSelectedKeys={['1']}>
                        <Menu.Item key="1">
                            <Link to="/">
                                Casatrar Investimentos
                                </Link>
                        </Menu.Item>
                        <Menu.Item key="2">
                            <Link to="listar">
                                Listar Investimentos
                                </Link>
                        </Menu.Item>
                    </Menu>
                </Header>
                <Content style={{ padding: '0 50px' }}>
                    <div className="site-layout-content">
                        <h2>CADASTRAR INVESTIMENTOS</h2>
                        <Form {...layout} name="basic"
                            initialValues={{
                                remenber: true,
                            }}
                            onFinish={onFinish}
                            onFinishFailed={onFinishFailed}
                        >
                            <Form.Item
                                label="Código do ativo"
                                name="active"
                                rules={[
                                    {
                                        required: true,
                                        message: 'Insira o código do ativo!'
                                    }
                                ]}
                            >
                                <Input />
                            </Form.Item>

                            <Form.Item
                                label="Valor"
                                name="value"
                                rules={[
                                    {
                                        required: true,
                                        message: 'Insira o valor do investimento!'
                                    }
                                ]}
                            >
                                <Input />
                            </Form.Item>
                            <Form.Item
                                label="Quantidade de cotas"
                                name="quota"
                                rules={[
                                    {
                                        required: true,
                                        message: 'Insira o valor da cota!'
                                    }
                                ]}
                            >
                                <InputNumber />
                            </Form.Item>

                            <Form.Item
                                label="Data da Compra"
                                name="purchase"
                                rules={[
                                    {
                                        required: true,
                                        message: 'Insira a data da compra!'
                                    },
                                ]}
                            >
                                <DatePicker />
                            </Form.Item>

                            <Form.Item
                                label="Categoria"
                                name="category"
                            >
                                <Select style={{ width: '80%' }} onChange={handleChange}>
                                    {categorias.map((item, index) => {
                                        return (
                                            <Option key={item.id} value={index} >
                                                {item.name}
                                            </Option>
                                        )
                                    })}
                                </Select>
                            </Form.Item>

                            <Form.Item {...tailLayout}>
                                <Button type="primary" htmlType="submit">
                                    Salvar
                                    </Button>
                            </Form.Item>
                        </Form>
                    </div>
                </Content>
                <Footer style={{ textAlign: 'center' }}>© AC Invest 2021</Footer>
            </Layout>
        </div>
    );
}
