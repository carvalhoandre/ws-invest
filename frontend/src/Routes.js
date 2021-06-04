import { BrowserRouter, Route, Switch } from "react-router-dom";

import Listar from './pages/Listar'
import Cadastrar from './pages/Cadastrar'

const Routes = () => (
  <BrowserRouter>
    <Switch>
      <Route exact path="/" component={Cadastrar} />
      <Route path="/listar" component={Listar} />
    </Switch>
  </BrowserRouter>
);

export default Routes;