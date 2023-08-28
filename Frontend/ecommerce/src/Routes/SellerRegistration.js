import axios from 'axios';
import { useState} from 'react';
import { useNavigate } from 'react-router-dom';


const SellerRegistration = () => {

  const [user, setUser] = useState({firstName: "",
                                    lastName: "",
                                    email: "",
                                    password: "",
                                    role: "SELLER",
                                    mobile: "",
                                    status: "PENDING"})

  const navigate = useNavigate();

  const onInputChange = (event) => {
    let copyOfUser = { ...user }
    copyOfUser[event.target.name] = event.target.value;
    setUser(copyOfUser);
}
  const Register = () => {
    axios.post("http://127.0.0.1:7070/user/register", user).then(res => {
                                                                          console.log(res.data);

                                                                          setUser({firstName: "",
                                                                          lastName: "",
                                                                          email: "",
                                                                          password: "",
                                                                          role: "SELLER",
                                                                          mobile: "",
                                                                          status: "PENDING" 
                                                                        })

                                                                        navigate("/login"); 
                                                                        }).catch(err => console.log(err));
  }

  return (
    <div className='container'>
      <h3>Add User</h3>
      <hr />
      <form>
        <div className='form-group'>
          <input
            type='text'
            className='form-control col-4'
            name='firstName'
            value={user.firstName}
            onChange={onInputChange}
            placeholder='Enter first name'
          />
        </div>
        <div className='form-group'>
          <input
            type='text'
            className='form-control col-4'
            name='lastName'
            value={user.lastName}
            onChange={onInputChange}
            placeholder='Enter last name'
          />
        </div>
        <div className='form-group'>
          <input
            type='tel'
            className='form-control col-4'
            name='mobile'
            value={user.mobile}
            onChange={onInputChange}
            placeholder='Enter mobile'
          />
        </div>
        <div className='form-group'>
          <input
            type='email'
            className='form-control col-4'
            name='email'
            value={user.email}
            onChange={onInputChange}
            placeholder='Enter email'
          />
        </div>
        <div className='form-group'>
          <input
            type='password'
            className='form-control col-4'
            name='password'
            value={user.password}
            onChange={onInputChange}
            placeholder='Enter Password'
          />
        </div>

        <div>
          <button type="button"  className='btn btn-primary'  onClick={Register}>
            Register
          </button>
        </div>
      </form>
      <hr />
    </div>
  );
};

export default SellerRegistration;
