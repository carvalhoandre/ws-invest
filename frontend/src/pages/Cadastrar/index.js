import { Form, Button, message, DatePicker, Layout, Menu, Input, InputNumber } from "antd";

import { Link } from 'react-router-dom'
import { saveInvestimento } from "../../service/services";

const { Header, Content, Footer } = Layout;

export default function Cadastrar() {

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
                                name="codigoAtivo"
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
                                name="valor"
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
                                name="cota"
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
                                name="dataCompra"
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
                                name="categoria"
                            >
                                <Input />
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
