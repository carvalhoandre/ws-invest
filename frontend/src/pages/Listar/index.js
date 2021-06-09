import { useEffect, useState } from 'react'
import "antd/dist/antd.css"
import { Link } from "react-router-dom";

import { Table, Button, message, Layout, Menu } from 'antd'

import { retrieveAllInvestimento, deleteInvestimento } from '../../service/services';


const { Header, Content, Footer } = Layout;
const { Column } = Table

export default function Listar() {

    const [investimento, setInvestimento] = useState([]);

    useEffect(() => {
        refreshInvestimento();
        return () => {

        }
    }, [investimento])

    async function refreshInvestimento(){
        retrieveAllInvestimento()
            .then(
                response => {
                    console.log(response)
                    setInvestimento(response.data)
                }
            )
    }

    function remove(record) {
        deleteInvestimento(record)
        message.success('Investimento removido com sucesso')
    }

    return (
        <div className="container">
            <Layout className="layout">
                <Header>
                    <div className="logo" />
                    <Menu theme="dark" mode="horizontal" defaultSelectedKeys={['2']}>
                        <Menu.Item key="1">
                            <Link to="/">
                                Cadastrar Investimento
                                </Link>
                        </Menu.Item>
                        <Menu.Item key="2">
                            <Link to="/listar">
                                Listar Investimentos
                                </Link>
                        </Menu.Item>
                    </Menu>
                </Header>
                <Content style={{ padding: '0 50px' }}>
                    <div className="site-layout-content">
                        <h2>INVESTIMENTOS</h2>
                        <Table dataSource={investimento}>
                            <Column title="Código do ativo" dataIndex="active" key="active" />
                            <Column title="Valor" dataIndex="value" key="value" />
                            <Column title="Quantidade de Cotas" dataIndex="quota" key="quota" />
                            <Column title="Data da Compra" dataIndex="purchase" key="purchase" />
                            <Column title="Remover" key="atualizar"
                                render={(text, record) => (<Button onClick={() => remove(record.id)}
                                    type="primary">Remover</Button>)}
                            />
                        </Table>
                    </div>
                    
                </Content>
                <Footer style={{ textAlign: 'center' }}>© AC Invest 2021</Footer>
            </Layout>
        </div>
    )
}
