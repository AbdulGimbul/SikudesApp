<?php
defined('BASEPATH') or exit('No direct script access allowed');

class ServerApi extends CI_Controller
{

    public function loginUser()
    {
        $email = $this->input->post('email');
        $password = $this->input->post('password');

        $this->db->where('email', $email);
        $this->db->where('password', $password);

        $q = $this->db->get('users_table');

        if ($q->num_rows() > 0) {
            $data['message'] = 'Login success';
            $data['status'] = 200;
            $data['user'] = $q->row();
        } else {
            $data['message'] = 'Email atau password salah';
            $data['status'] = 404;
        }

        echo json_encode($data);
    }

    public function registerUser()
    {
        $username = $this->input->post('username');
        $email = $this->input->post('email');
        $password = $this->input->post('password');

        $this->db->where('username', $username);

        $q = $this->db->get('users_table');

        if ($q->num_rows() > 0) {
            $data['message'] = 'Username sudah terdaftar, coba username lain';
            $data['status'] = 404;
        } else {
            $simpan['username'] = $username;
            $simpan['email'] = $email;
            $simpan['password'] = md5($password);

            $q = $this->db->insert('users_table', $simpan);

            if ($q) {
                # code...
                $data['message'] = 'success';
                $data['status'] = 200;
            } else {
                $data['message'] = 'error';
                $data['status'] = 404;
            }
        }

        echo json_encode($data);
    }

    //fungsi untuk create
    public function addPenduduk()
    {
        //deklarasi variabel
        $nik = $this->input->post('nik');
        $no_kk = $this->input->post('no_kk');
        $nama = $this->input->post('nama');
        $tempat_lahir = $this->input->post('tempat_lahir');
        $tgl_lahir = $this->input->post('tgl_lahir');
        $jk = $this->input->post('jk');
        $alamat = $this->input->post('alamat');
        $agama = $this->input->post('agama');
        $status = $this->input->post('status');
        $pekerjaan = $this->input->post('pekerjaan');
        $goldar = $this->input->post('goldar');


        //isikan variabel dengan nama file
        $data['nik'] = $nik;
        $data['no_kk'] = $no_kk;
        $data['nama'] = $nama;
        $data['tempat_lahir'] = $tempat_lahir;
        $data['tgl_lahir'] = $tgl_lahir;
        $data['jk'] = $jk;
        $data['alamat'] = $alamat;
        $data['agama'] = $agama;
        $data['status'] = $status;
        $data['pekerjaan'] = $pekerjaan;
        $data['goldar'] = $goldar;

        $q = $this->db->insert('tabel_penduduk', $data);

        //cek insert berhasil apa enggak
        if ($q) {
            $response['pesan'] = 'insert berhasil';
            $response['status'] = 200;
        } else {
            $response['pesan'] = 'insert error';
            $response['status'] = 404;
        }

        echo json_encode($response);
    }

    public function addAparatur()
    {
        //deklarasi variabel
        $nipd = $this->input->post('nipd');
        $nama = $this->input->post('nama');
        $jabatan = $this->input->post('jabatan');
        $pendidikan = $this->input->post('pendidikan');
        $tmt = $this->input->post('tmt');
        $jk = $this->input->post('jk');

        //isikan variabel dengan nama file
        $data['nipd'] = $nipd;
        $data['nama'] = $nama;
        $data['jabatan'] = $jabatan;
        $data['pendidikan'] = $pendidikan;
        $data['tmt'] = $tmt;
        $data['jk'] = $jk;

        $q = $this->db->insert('tabel_struktural', $data);

        //cek insert berhasil apa enggak
        if ($q) {
            $response['pesan'] = 'insert berhasil';
            $response['status'] = 200;
        } else {
            $response['pesan'] = 'insert error';
            $response['status'] = 404;
        }

        echo json_encode($response);
    }

    public function addNote()
    {
        //deklarasi variabel
        $judul = $this->input->post('judul');
        $deskripsi = $this->input->post('deskripsi');
        $this->load->helper('date');
        $dateCurrent = "%Y-%m-%d %h:%i %a";

        //isikan variabel dengan nama file
        $data['judul'] = $judul;
        $data['deskripsi'] = $deskripsi;
        $data['tanggal'] = $dateCurrent;


        $q = $this->db->insert('tabel_note', $data);

        //cek insert berhasil apa enggak
        if ($q) {
            $response['pesan'] = 'insert berhasil';
            $response['tanggal'] = $dateCurrent;
            $response['status'] = 200;
        } else {
            $response['pesan'] = 'insert error';
            $response['status'] = 404;
        }

        echo json_encode($response);
    }

    //fungsi untuk READ
    public function getDataPenduduk()
    {
        $q = $this->db->get('tabel_penduduk');
        if ($q->num_rows() > 0) {
            $response['pesan'] = 'data ada';
            $response['status'] = 200;
            //1 row
            $response['penduduk'] = $q->row();
            $response['penduduk'] = $q->result();
        } else {
            $response['pesan'] = 'data tidak ada';
            $response['status'] = 404;
        }
        echo json_encode($response);
    }

    public function getNote()
    {
        $q = $this->db->get('tabel_note');
        if ($q->num_rows() > 0) {
            $response['pesan'] = 'data ada';
            $response['status'] = 200;
            //1 row
            $response['note'] = $q->row();
            $response['note'] = $q->result();
        } else {
            $response['pesan'] = 'data tidak ada';
            $response['status'] = 404;
        }
        echo json_encode($response);
    }

    public function getAparatur()
    {
        $q = $this->db->get('tabel_struktural');
        if ($q->num_rows() > 0) {
            $response['pesan'] = 'data ada';
            $response['status'] = 200;
            //1 row
            $response['aparatur'] = $q->row();
            $response['aparatur'] = $q->result();
        } else {
            $response['pesan'] = 'data tidak ada';
            $response['status'] = 404;
        }
        echo json_encode($response);
    }

    public function getDataLaki()
    {
        $jk = 'Laki-laki';
        $q = $this->db->get_where('tabel_penduduk ', array('jk' => $jk));
        if ($q->num_rows() > 0) {
            $response['pesan'] = 'data ada';
            $response['status'] = 200;
            //1 row
            $response['penduduk'] = $q->row();
            $response['penduduk'] = $q->result();
        } else {
            $response['pesan'] = 'data tidak ada';
            $response['status'] = 404;
        }
        echo json_encode($response);
    }

    public function getDataPerempuan()
    {
        $jk = 'Perempuan';
        $q = $this->db->get_where('tabel_penduduk ', array('jk' => $jk));
        if ($q->num_rows() > 0) {
            $response['pesan'] = 'data ada';
            $response['status'] = 200;
            //1 row
            $response['penduduk'] = $q->row();
            $response['penduduk'] = $q->result();
        } else {
            $response['pesan'] = 'data tidak ada';
            $response['status'] = 404;
        }
        echo json_encode($response);
    }

    public function getStatusMenikah()
    {
        $status = 'Menikah';
        $q = $this->db->get_where('tabel_penduduk ', array('status' => $status));
        if ($q->num_rows() > 0) {
            $response['pesan'] = 'data ada';
            $response['status'] = 200;
            //1 row
            $response['penduduk'] = $q->row();
            $response['penduduk'] = $q->result();
        } else {
            $response['pesan'] = 'data tidak ada';
            $response['status'] = 404;
        }
        echo json_encode($response);
    }

    public function getStatusCerai()
    {
        $status = 'Cerai';
        $q = $this->db->get_where('tabel_penduduk ', array('status' => $status));
        if ($q->num_rows() > 0) {
            $response['pesan'] = 'data ada';
            $response['status'] = 200;
            //1 row
            $response['penduduk'] = $q->row();
            $response['penduduk'] = $q->result();
        } else {
            $response['pesan'] = 'data tidak ada';
            $response['status'] = 404;
        }
        echo json_encode($response);
    }

    public function getStatusCeraiMati()
    {
        $status = 'Cerai Mati';
        $q = $this->db->get_where('tabel_penduduk ', array('status' => $status));
        if ($q->num_rows() > 0) {
            $response['pesan'] = 'data ada';
            $response['status'] = 200;
            //1 row
            $response['penduduk'] = $q->row();
            $response['penduduk'] = $q->result();
        } else {
            $response['pesan'] = 'data tidak ada';
            $response['status'] = 404;
        }
        echo json_encode($response);
    }

    public function getStatusLajang()
    {
        $status = 'Lajang';
        $q = $this->db->get_where('tabel_penduduk ', array('status' => $status));
        if ($q->num_rows() > 0) {
            $response['pesan'] = 'data ada';
            $response['status'] = 200;
            //1 row
            $response['penduduk'] = $q->row();
            $response['penduduk'] = $q->result();
        } else {
            $response['pesan'] = 'data tidak ada';
            $response['status'] = 404;
        }
        echo json_encode($response);
    }

    public function getGoldarA()
    {
        $goldar = 'A';
        $q = $this->db->get_where('tabel_penduduk ', array('goldar' => $goldar));
        if ($q->num_rows() > 0) {
            $response['pesan'] = 'data ada';
            $response['status'] = 200;
            //1 row
            $response['penduduk'] = $q->row();
            $response['penduduk'] = $q->result();
        } else {
            $response['pesan'] = 'data tidak ada';
            $response['status'] = 404;
        }
        echo json_encode($response);
    }

    public function getGoldarAB()
    {
        $goldar = 'AB';
        $q = $this->db->get_where('tabel_penduduk ', array('goldar' => $goldar));
        if ($q->num_rows() > 0) {
            $response['pesan'] = 'data ada';
            $response['status'] = 200;
            //1 row
            $response['penduduk'] = $q->row();
            $response['penduduk'] = $q->result();
        } else {
            $response['pesan'] = 'data tidak ada';
            $response['status'] = 404;
        }
        echo json_encode($response);
    }

    public function getGoldarB()
    {
        $goldar = 'B';
        $q = $this->db->get_where('tabel_penduduk ', array('goldar' => $goldar));
        if ($q->num_rows() > 0) {
            $response['pesan'] = 'data ada';
            $response['status'] = 200;
            //1 row
            $response['penduduk'] = $q->row();
            $response['penduduk'] = $q->result();
        } else {
            $response['pesan'] = 'data tidak ada';
            $response['status'] = 404;
        }
        echo json_encode($response);
    }

    public function getGoldarO()
    {
        $goldar = 'O';
        $q = $this->db->get_where('tabel_penduduk ', array('goldar' => $goldar));
        if ($q->num_rows() > 0) {
            $response['pesan'] = 'data ada';
            $response['status'] = 200;
            //1 row
            $response['penduduk'] = $q->row();
            $response['penduduk'] = $q->result();
        } else {
            $response['pesan'] = 'data tidak ada';
            $response['status'] = 404;
        }
        echo json_encode($response);
    }

    public function getKerjaWiraswasta()
    {
        $pekerjaan = 'Wiraswasta';
        $q = $this->db->get_where('tabel_penduduk ', array('pekerjaan' => $pekerjaan));
        if ($q->num_rows() > 0) {
            $response['pesan'] = 'data ada';
            $response['status'] = 200;
            //1 row
            $response['penduduk'] = $q->row();
            $response['penduduk'] = $q->result();
        } else {
            $response['pesan'] = 'data tidak ada';
            $response['status'] = 404;
        }
        echo json_encode($response);
    }

    public function getKerjaGuru()
    {
        $pekerjaan = 'Guru';
        $q = $this->db->get_where('tabel_penduduk ', array('pekerjaan' => $pekerjaan));
        if ($q->num_rows() > 0) {
            $response['pesan'] = 'data ada';
            $response['status'] = 200;
            //1 row
            $response['penduduk'] = $q->row();
            $response['penduduk'] = $q->result();
        } else {
            $response['pesan'] = 'data tidak ada';
            $response['status'] = 404;
        }
        echo json_encode($response);
    }

    public function getKerjaPNS()
    {
        $pekerjaan = 'PNS';
        $q = $this->db->get_where('tabel_penduduk ', array('pekerjaan' => $pekerjaan));
        if ($q->num_rows() > 0) {
            $response['pesan'] = 'data ada';
            $response['status'] = 200;
            //1 row
            $response['penduduk'] = $q->row();
            $response['penduduk'] = $q->result();
        } else {
            $response['pesan'] = 'data tidak ada';
            $response['status'] = 404;
        }
        echo json_encode($response);
    }

    public function getKerjaTani()
    {
        $pekerjaan = 'Petani';
        $q = $this->db->get_where('tabel_penduduk ', array('pekerjaan' => $pekerjaan));
        if ($q->num_rows() > 0) {
            $response['pesan'] = 'data ada';
            $response['status'] = 200;
            //1 row
            $response['penduduk'] = $q->row();
            $response['penduduk'] = $q->result();
        } else {
            $response['pesan'] = 'data tidak ada';
            $response['status'] = 404;
        }
        echo json_encode($response);
    }

    public function getKerjaKaryawan()
    {
        $pekerjaan = 'Karyawan';
        $q = $this->db->get_where('tabel_penduduk ', array('pekerjaan' => $pekerjaan));
        if ($q->num_rows() > 0) {
            $response['pesan'] = 'data ada';
            $response['status'] = 200;
            //1 row
            $response['penduduk'] = $q->row();
            $response['penduduk'] = $q->result();
        } else {
            $response['pesan'] = 'data tidak ada';
            $response['status'] = 404;
        }
        echo json_encode($response);
    }


    //fungsi untuk DELETE
    public function deletePenduduk()
    {
        $nik = $this->input->post('nik');
        $this->db->where('nik', $nik);
        $status = $this->db->delete('tabel_penduduk');
        if ($status == true) {
            $response['pesan'] = 'data berhasil dihapus';
            $response['status'] = 200;
        } else {
            $response['pesan'] = 'data gagal dihapus';
            $response['status'] = 404;
        }
        echo json_encode($response);
    }

    public function deleteNote()
    {
        $id = $this->input->post('id');
        $this->db->where('id', $id);
        $status = $this->db->delete('tabel_note');
        if ($status == true) {
            $response['pesan'] = 'data berhasil dihapus';
            $response['status'] = 200;
        } else {
            $response['pesan'] = 'data gagal dihapus';
            $response['status'] = 404;
        }
        echo json_encode($response);
    }

    public function deleteAparatur()
    {
        $nipd = $this->input->post('nipd');
        $this->db->where('nipd', $nipd);
        $status = $this->db->delete('tabel_struktural');
        if ($status == true) {
            $response['pesan'] = 'data berhasil dihapus';
            $response['status'] = 200;
        } else {
            $response['pesan'] = 'data gagal dihapus';
            $response['status'] = 404;
        }
        echo json_encode($response);
    }

    //fungsi untuk UPDATE
    public function updatePenduduk()
    {
        //deklarasi variabel
        $nik = $this->input->post('nik');
        $no_kk = $this->input->post('no_kk');
        $nama = $this->input->post('nama');
        $tempat_lahir = $this->input->post('tempat_lahir');
        $tgl_lahir = $this->input->post('tgl_lahir');
        $jk = $this->input->post('jk');
        $alamat = $this->input->post('alamat');
        $agama = $this->input->post('agama');
        $status = $this->input->post('status');
        $pekerjaan = $this->input->post('pekerjaan');
        $goldar = $this->input->post('goldar');

        $this->db->where('nik', $nik);

        //isikan variabel dengan nama file
        $data['nik'] = $nik;
        $data['no_kk'] = $no_kk;
        $data['nama'] = $nama;
        $data['tempat_lahir'] = $tempat_lahir;
        $data['tgl_lahir'] = $tgl_lahir;
        $data['jk'] = $jk;
        $data['alamat'] = $alamat;
        $data['agama'] = $agama;
        $data['status'] = $status;
        $data['pekerjaan'] = $pekerjaan;
        $data['goldar'] = $goldar;

        $q = $this->db->update('tabel_penduduk', $data);

        //cek insert berhasil apa nggak
        if ($q) {
            $response['pesan'] =  'update berhasil';
            $response['status'] = 200;
        } else {
            $response['pesan'] = 'update gagal';
            $response['status'] = 404;
        }

        echo json_encode($response);
    }

    public function updateNote()
    {
        //deklarasi variabel
        $id = $this->input->post('id');
        $judul = $this->input->post('judul');
        $deskripsi = $this->input->post('deskripsi');
        $this->load->helper('date');
        $dateCurrent = "%Y-%m-%d %h:%i %a";

        $this->db->where('id', $id);

        //isikan variabel dengan nama file
        $data['id'] = $id;
        $data['judul'] = $judul;
        $data['deskripsi'] = $deskripsi;
        $data['tanggal'] = $dateCurrent;

        $q = $this->db->update('tabel_note', $data);

        //cek insert berhasil apa nggak
        if ($q) {
            $response['pesan'] =  'update berhasil';
            $response['status'] = 200;
        } else {
            $response['pesan'] = 'update gagal';
            $response['status'] = 404;
        }

        echo json_encode($response);
    }

    public function updateAparatur()
    {
        //deklarasi variabel
        $nipd = $this->input->post('nipd');
        $nama = $this->input->post('nama');
        $jabatan = $this->input->post('jabatan');
        $pendidikan = $this->input->post('pendidikan');
        $tmt = $this->input->post('tmt');
        $jk = $this->input->post('jk');

        $this->db->where('nipd', $nipd);

        //isikan variabel dengan nama file
        $data['nipd'] = $nipd;
        $data['nama'] = $nama;
        $data['jabatan'] = $jabatan;
        $data['pendidikan'] = $pendidikan;
        $data['tmt'] = $tmt;
        $data['jk'] = $jk;

        $q = $this->db->update('tabel_struktural', $data);

        //cek insert berhasil apa nggak
        if ($q) {
            $response['pesan'] =  'update berhasil';
            $response['status'] = 200;
        } else {
            $response['pesan'] = 'update gagal';
            $response['status'] = 404;
        }

        echo json_encode($response);
    }

    public function fetchPenduduk()
    {

        if (isset($_GET['key'])) {
            $key = $_GET["key"];
            $sql = "SELECT * FROM tabel_penduduk WHERE nama LIKE '%$key%'";
            $q = $this->db->query($sql);
            if ($q->num_rows() > 0) {
                $response['pesan'] = 'data ada';
                $response['status'] = 200;
                //1 row
                $response['penduduk'] = $q->row();
                $response['penduduk'] = $q->result();
            } else {
                $response['pesan'] = 'data tidak ada';
                $response['status'] = 404;
            }
            echo json_encode($response);
        } else {
            $q = $this->db->get('tabel_penduduk');
            if ($q->num_rows() > 0) {
                $response['pesan'] = 'data ada';
                $response['status'] = 200;
                //1 row
                $response['penduduk'] = $q->row();
                $response['penduduk'] = $q->result();
            } else {
                $response['pesan'] = 'data tidak ada';
                $response['status'] = 404;
            }
            echo json_encode($response);
        }
    }
}
