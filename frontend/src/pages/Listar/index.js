import "antd/dist/antd.css"
import { Table, Button, message, Layout, Menu } from 'antd'
import { Link } from "react-router-dom";
import { useState } from 'react'

const { Header, Content, Footer } = Layout;
const {Column} = Table

export default function Listar(){

    const [investimento, setInvestimento] = useState([]);

    function remove(record){
        message.success('Investimento removido com sucesso')
    }
    
    return(
        <div className="container">
            <Layout className="layout">
                <Header>
                    <div className="logo">
                        <Menu theme="dark" mode="horizontal" defaultSelectedKeys={['2']}>
                            <Menu.Item key="1">
                                <Link to="/cadastrar">
                                    Cadastrar Investimento
                                </Link>
                            </Menu.Item>
                            <Menu.Item key="2">
                                <Link to="/listar">
                                    Listar Investimentos
                                </Link>
                            </Menu.Item>
                        </Menu>
                    </div>
                </Header>
                <Content style={{ padding: '0 50px' }}>
                    <div className="site-layout-content">
                        <h2>INVESTIMENTOS</h2>
                        <Table data={investimento}>
                            <Column title="Código do ativo" dataIndex="codigoAtivo" key="id" />
                            <Column title="Valor" dataIndex="dataIndex" key="valor" />
                            <Column title="Quantidade de Cotas" dataIndex="quantidadeCotas" key="id" />
                            <Column title="Data da Compra" dataIndex="dataCompra" key="id" />
                            <Column title="Remover" key="atualizar" 
                                render={(text, record) => (<Button onClick={() => remove(record)}
                                    type="primary">Remover</Button>)}
                            />
                        </Table>
                    </div>
                </Content>
                <Footer style={{ textAlign: 'center'}}>AC Invest 2021</Footer>
            </Layout>
        </div>
    )
}
