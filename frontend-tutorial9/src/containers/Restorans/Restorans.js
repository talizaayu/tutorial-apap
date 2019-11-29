import React, { Component } from 'react';
import Restoran from '../../components/Restoran/Restoran';
import classes from "./Restorans.module.css";
import Axios from '../../axios-restoran.js';
import Modal from '../../components/UI/Modal/Modal';
import Button from '../../components/UI/Button/Button';

class Restorans extends Component{
    constructor(props){
        super(props);
        this.state = {
            restorans: [],
            isCreate: false,
            isEdit: false,
            isLoading: true,
            nama: "",
            alamat: "",
            nomorTelepon: "",
            rating: "",
            searchText: "",
            filteredRestorans : [],
            currentPage: 1,
            restoransPerPage: 5,
            upperPageBound: 3,
            lowerPageBound: 0,
        }
        this.handleClick = this.handleClick.bind(this);
    }

    handleClick(event) {
        this.setState({
          currentPage: Number(event.target.id)
        });
    }    

    handleSearch(event) {
        const newSearchText = event.target.value;
        let newList = [];
        let currentList = [];

        this.setState({
            searchText : newSearchText
        })

        if (event.target.value !== "") {
            currentList = this.state.restorans;
            newList = currentList.filter(restoran => {
                return restoran.nama.startsWith(newSearchText);
            });
        } else {
            newList = this.state.restorans;
        }
        this.setState({
            filteredRestorans: newList
        });
    }

    addRestoranHandler = () => {
        console.log("add")
        this.setState({ isCreate: true });
    }

    canceledHandler = () => {
        this.setState({ isCreate: false, isEdit: false});
    }

    changeHandler = event => {
        const { name, value } = event.target;
        this.setState({ [name]: value});
    }

    editRestoranHandler(restoran) {
        this.setState({
            isEdit: true,
            idRestoran: restoran.idRestoran,
            nama: restoran.nama,
            nomorTelepon: restoran.nomorTelepon,
            rating: restoran.rating,
            alamat: restoran.alamat
        })
    }

    submitAddRestoranHandler = event => {
        event.preventDefault();
        this.setState({ isLoading: true });
        this.addRestoran();
        this.canceledHandler();
    }

    submitEditRestoranHandler = event => {
        // console.log("editing")
        event.preventDefault();
        this.setState({ isLoading: true });
        this.editRestoran();
        this.canceledHandler();
    }

    async editRestoran(){
        const restoranToEdit = {
            idRestoran: this.state.idRestoran,
            nama: this.state.nama,
            alamat: this.state.alamat,
            nomorTelepon: this.state.nomorTelepon,
            rating: this.state.rating
        };

        await Axios.put("/restoran/" + this.state.idRestoran, restoranToEdit);
        await this.loadRestorans();
        this.canceledHandler();
    }

    async addRestoran(){
        const restoranToAdd = {
            nama: this.state.nama,
            alamat: this.state.alamat,
            nomorTelepon: this.state.nomorTelepon,
            rating: this.state.rating
        };

        await Axios.post("/restoran", restoranToAdd);
        await this.loadRestorans();
        // Latihan Nomor 1
        this.setState({nama: " ", alamat: " ", nomorTelepon: " ", rating: " "});
    }

    async deleteRestoranHandler(restoranId){
        await Axios.delete(`/restoran/${restoranId}`);
        await this.loadRestorans();
    }

    componentDidMount() {
        this.loadRestorans();
    }

    loadRestorans = async () => {
        const fetchedRestorans = [];
        const response = await Axios.get("/restorans");
        for (let key in response.data) {
            fetchedRestorans.push({
                ...response.data[key]
            });
        }
        this.setState({
            restorans: fetchedRestorans,
            filteredRestorans : fetchedRestorans
        });
    };

    render(){
        const { filteredRestorans, restorans, currentPage, restoransPerPage, upperPageBound,lowerPageBound } = this.state;

        const indexOfLastTodo = currentPage * restoransPerPage;
        const indexOfFirstTodo = indexOfLastTodo - restoransPerPage;
        const currentRestorans = filteredRestorans.slice(indexOfFirstTodo, indexOfLastTodo);

        console.log(filteredRestorans);
        console.log(restorans);

        const renderRestorans = currentRestorans.map((restoran) => {
            return (
                <Restoran
                    key={restoran.id}
                    nama={restoran.nama}
                    alamat={restoran.alamat}
                    nomorTelepon={restoran.nomorTelepon}
                    edit={() => this.editRestoranHandler(restoran)}
                    delete={() => this.deleteRestoranHandler(restoran.idRestoran)}
                />
            )
        });

        const pageNumbers = [];
        for (let i = 1; i <= Math.ceil(filteredRestorans.length / restoransPerPage); i++) {
            pageNumbers.push(i);
        }

        const renderPageNumbers = pageNumbers.map(number => {
            if(number === 1 && currentPage === 1){
                return(
                    <a key={number} className='active' id={number}><a href='#' id={number} onClick={this.handleClick}> {number} </a></a>
                )
            }
            else if((number < upperPageBound + 1) && number > lowerPageBound){
                return(
                    <a key={number} id={number}><a href='#' id={number} onClick={this.handleClick}> {number} </a></a>
                )
            }
        });

        return(
            <React.Fragment>
                <Modal show={this.state.isCreate || this.state.isEdit}
                modalClosed={this.cancledHandler}>
                    {this.renderForm()}
                </Modal>
                <div className={classes.Title}> All Restorans </div>
                
                <div className={classes.ButtonLayout}>
                    <button  
                    className={classes.AddRestoranButton}
                    onClick={this.addRestoranHandler}>
                        + Add New Restoran
                    </button>
                </div>


                <div className={classes.wrap} >
                    <div className={classes.search}>
                        <input type="text" className={classes.searchTerm} onChange={e => this.handleSearch(e)} value={this.state.searchText} placeholder="Search..." />
                    </div>
                </div>

                <div className={classes.Restorans}>
                {renderRestorans}
                    {/* {this.state.filteredRestorans && 
                        this.state.filteredRestorans.map(restoran =>
                            <Restoran
                                key={restoran.id}
                                nama={restoran.nama}
                                alamat={restoran.alamat}
                                nomorTelepon={restoran.nomorTelepon}
                                edit={() => this.editRestoranHandler(restoran)}
                                delete={() => this.deleteRestoranHandler(restoran.idRestoran)}
                            />
                        )} */}
                </div>
                <div>
                    <ul id="page-numbers">
                        {renderPageNumbers}
                    </ul>
                </div>
            </React.Fragment>
        );
    }

    renderForm() {
        const { isEdit } = this.state;
        return (
            <form>
                <input
                className={classes.Input}
                name="nama"
                type="text"
                placeholder="Nama"
                value={this.state.nama}
                onChange={this.changeHandler}
                />
                <input
                className={classes.Input}
                name="nomorTelepon"
                type="number"
                placeholder="Nomor Telepon"
                value={this.state.nomorTelepon}
                onChange={this.changeHandler}
                />
                <textarea
                className={classes.TextArea}
                name="alamat"
                type="text"
                placeholder="Alamat"
                value={this.state.alamat}
                onChange={this.changeHandler}
                />
                <input
                className={classes.Input}
                name="rating"
                type="number"
                placeholder="Rating"
                value={this.state.rating}
                onChange={this.changeHandler}
                />
                <Button btnType="Danger" onClick={this.canceledHandler}>
                    CANCEL
                </Button>
                <Button btnType="Success" onClick={
                    isEdit ? this.submitEditRestoranHandler : this.submitAddRestoranHandler}>
                    SUBMIT
                </Button>
            </form>
        );
    }
}

export default Restorans;